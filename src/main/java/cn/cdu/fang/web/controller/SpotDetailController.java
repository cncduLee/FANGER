package cn.cdu.fang.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.cdu.fang.constant.ShipWithSpot;
import cn.cdu.fang.entity.Spot;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.entity.WithSpot;
import cn.cdu.fang.service.SpotService;
import cn.cdu.fang.service.UserService;
import cn.cdu.fang.service.WithSpotService;
import cn.cdu.fang.vo.AjaxResult;
import cn.cdu.fang.vo.AjaxResultCode;
import cn.cdu.fang.web.utill.SessionUtil;

@Controller
public class SpotDetailController {
	
	@Autowired
	SpotService spotService;
	@Autowired
	UserService userService;
	@Autowired
	SessionUtil sessionUtil;
	@Autowired
	WithSpotService withSpotService;
	
	@RequestMapping(value="/spotDetail",method=RequestMethod.GET)
	public String detail(
			@RequestParam(value = "spotId", required = true) Integer spotId,
			Model model,HttpSession session){
		
		Assert.assertNotNull(spotId);
		Spot spot = spotService.getEntity(spotId);
		if(spot == null) return "";
		model.addAttribute("spotDetail",spot);
		
		return "spot/detail";
	}
	
	@RequestMapping(value="/spotDetail/download/{spotId}",method=RequestMethod.GET)
    public ModelAndView download(@PathVariable("spotId")
    		Integer spotId, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        java.io.BufferedInputStream bis = null;
        java.io.BufferedOutputStream bos = null;
        
        Spot spot = spotService.getEntity(spotId);
        String fileName = spot.getImages().getResId().substring(spot.getImages().getResId().lastIndexOf('/')+1);
        
        String ctxPath = request.getSession().getServletContext().getRealPath("/");
        String downLoadPath = ctxPath + spot.getImages().getResId();
        
        System.out.println(downLoadPath);
        
        try {
            long fileLength = new File(downLoadPath).length();
            response.setContentType("application/x-msdownload;");
            response.setHeader("Content-disposition", "attachment; filename="
                    + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            
            
            response.setHeader("Content-Length", String.valueOf(fileLength));
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            
            spot.setDownloadCount(spot.getDownloadCount() + 1);
            spotService.update(spot);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return null;
    }
	
	@RequestMapping(value="/spotDetail/share/{spotId}",method=RequestMethod.GET)
	public @ResponseBody AjaxResult shareSpot(@PathVariable("spotId")
			Integer spotId, HttpSession session, 
			HttpServletResponse response){
		try{

			Spot spot = spotService.getEntity(spotId);
			User tracked = sessionUtil.getSignInUser(session);
			
			if(tracked == null) return new AjaxResult(AjaxResultCode.NO_AUTH);
			
			WithSpot ws = new WithSpot();
			ws.setCreatedAt(new Date());
			ws.setType(ShipWithSpot.SHARE);
			ws.setStatus(0);
			ws.setTracked(tracked);
			ws.setTarget(spot);
			
			withSpotService.save(ws);
			
			
			spot.setShareCount(spot.getShareCount()+1);
			spotService.update(spot);
			
			return new AjaxResult(AjaxResultCode.SUCCESS);
			
		}catch(Exception e){
			return new AjaxResult(AjaxResultCode.EXCEPTION);
		}  
	}  
}
