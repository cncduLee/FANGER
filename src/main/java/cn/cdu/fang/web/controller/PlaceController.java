package cn.cdu.fang.web.controller;


import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.cdu.fang.entity.Place;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.service.PlaceService;
import cn.cdu.fang.vo.AjaxResult;
import cn.cdu.fang.vo.AjaxResultCode;
import cn.cdu.fang.vo.PlaceCreationVo;
import cn.cdu.fang.vo.PlaceJson;
import cn.cdu.fang.web.utill.AjaxUtil;
import cn.cdu.fang.web.utill.SessionUtil;

@Controller
public class PlaceController {
	
	@Autowired
	AjaxUtil ajaxUtil;
	@Autowired
	SessionUtil sessionUtil;
	@Autowired
	PlaceService placeService;
	
	@RequestMapping(value="/places/create", method=RequestMethod.POST)
	public @ResponseBody AjaxResult create(@Valid PlaceCreationVo vo, 
			BindingResult result, ModelAndView mav, HttpSession session){
		
		User signInUser = sessionUtil.getSignInUser(session);
		
		if(signInUser==null){
			return new AjaxResult(AjaxResultCode.NEED_SIGNIN);
		}
		
		if(result.hasErrors()){
			return new AjaxResult(AjaxResultCode.INVALID);
		}
		Place place = Place.builPlace(vo, signInUser);
		placeService.save(place);
		
		return new AjaxResult(AjaxResultCode.SUCCESS, PlaceJson.builtPlaceJson(place));
	}
	
	
	
	
	@RequestMapping(value="/citymeta", method=RequestMethod.GET)
	public @ResponseBody AjaxResult meta(HttpServletRequest request, 
			ModelAndView mav, HttpSession session){
		return new AjaxResult(AjaxResultCode.SUCCESS, new CityMeta("全国","quanguo", new Double[]{104.1865318,30.647404}, 3));
	}


	public class CityMeta implements Serializable {
		private static final long serialVersionUID = 3321450456991162507L;
		private String name;
		private String pinyin;
		private Double[] lngLat;
		private Integer zoom;
		
		public CityMeta(String name, String pinyin, Double[] lngLat,
				Integer zoom) {
			super();
			this.name = name;
			this.pinyin = pinyin;
			this.lngLat = lngLat;
			this.zoom = zoom;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPinyin() {
			return pinyin;
		}

		public void setPinyin(String pinyin) {
			this.pinyin = pinyin;
		}

		public Double[] getLngLat() {
			return lngLat;
		}

		public void setLngLat(Double[] lngLat) {
			this.lngLat = lngLat;
		}

		public Integer getZoom() {
			return zoom;
		}

		public void setZoom(Integer zoom) {
			this.zoom = zoom;
		}	
		
	}
}

