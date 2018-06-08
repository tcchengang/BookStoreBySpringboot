package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.Store;
import com.example.demo.service.OrderService;
import com.example.demo.service.StoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class StoreController {
	@Autowired
	private  StoreService storeService;
	
	@RequestMapping("/getAllStore")
	public String getAllStore(@RequestParam(value="pageNum",defaultValue="1") Integer pageNum 
			, @RequestParam(value="userId") String userId,Model model) {
		PageHelper.startPage(pageNum, 5);
		List<Store> stores =storeService.getAllStores();
		PageInfo pageInfo=new PageInfo(stores,5);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("userId", userId);
		return "freemaker/storeInfo";
	}
	@RequestMapping("/addStore")
	public void addStore() {
		Store store =new Store();
		for(int i=2;i<=43;i++) {
			store.setBookId(i+"");
			store.setStoreLeftnum(10);
			store.setStoreMoney((float) 0.0);
			store.setStoreSalednum(0);
			storeService.insert(store);
		}
	}
	
	@RequestMapping("/insertStore")
	public String insertStore(Store store,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum 
			, @RequestParam(value="userId") String userId,Model model) {
		storeService.insert(store);
		PageHelper.startPage(pageNum, 5);
		List<Store> stores =storeService.getAllStores();
		PageInfo pageInfo=new PageInfo(stores,5);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("userId", userId);
		return "freemaker/storeInfo";
	}
	@GetMapping("toAddStore")
	public String toAddStore(@RequestParam(value="userId",required=false) String userId,Model model) {
		model.addAttribute("userId", userId);
		return "freemaker/addStore";
	}
	@RequestMapping("/selectStores")
	public String selectStore(@RequestParam(value="pageNum",defaultValue="1") Integer pageNum 
			, @RequestParam(value="userId") String userId,@RequestParam(value="bookId") String bookId,Model model) {
		PageHelper.startPage(pageNum, 5);
		List<Store> stores =storeService.getStoresByBookId(bookId);
		PageInfo pageInfo=new PageInfo(stores,5);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("userId", userId);
		return "freemaker/storeInfo";
	}
}
