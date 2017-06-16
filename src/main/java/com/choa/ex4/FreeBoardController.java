package com.choa.ex4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.freeboard.FreeBoardDTO;
import com.choa.freeboard.FreeBoardServiceImpl;

@Controller
@RequestMapping(value = "/freeboard/**")
public class FreeBoardController {
	@Autowired
	private FreeBoardServiceImpl freeBoardService;
	
	@RequestMapping(value= "freeBoardList", method = RequestMethod.GET)
	public String freeBoardList(Model model, @RequestParam(defaultValue = "1") Integer curPage) throws Exception{
		System.out.println("freeBoardList Service");
		
		List<BoardDTO> freeBoardList = freeBoardService.boardList(curPage);
		model.addAttribute("boardList", freeBoardList);
		model.addAttribute("board", "freeBoard");
		
		return "board/boardList";
	}
	
	@RequestMapping(value= "freeBoardView", method = RequestMethod.GET)
	public void freeBoardView(Model model, Integer num) throws Exception{
		System.out.println("freeBoardView Service");
		/*
		FreeBoardDTO freeBoardDTO = freeBoardService.freeBoardView(num);
		model.addAttribute("freeBoardDTO", freeBoardDTO);*/
	}
	
	@RequestMapping(value= "freeBoardWrite", method = RequestMethod.GET)
	public void freeBoardWrite(Model model){
		System.out.println("freeBoardWrite Service");
		
		/*model.addAttribute("path", "Write");*/
	}
	
	@RequestMapping(value= "freeBoardWrite", method = RequestMethod.POST)
	public void freeBoardWrite(FreeBoardDTO freeBoardDTO, RedirectAttributes reAttributes) throws Exception{
		System.out.println("freeBoardWrite Process Service");
		
		/*int result = freeBoardService.freeBoardWrite(freeBoardDTO);
		String message = "Write Fail";
		if(result > 0){
			message = "Write Success";
		}
		reAttributes.addFlashAttribute("message", message);
		return "redirect:freeBoardList";*/
	}
	
	@RequestMapping(value= "freeBoardUpdate", method = RequestMethod.GET)
	public void freeBoardUpdate(Model model, Integer num) throws Exception{
		System.out.println("freeBoardUpdate Service");
		
		/*FreeBoardDTO freeBoardDTO = freeBoardService.freeBoardView(num);
		model.addAttribute("freeBoardDTO", freeBoardDTO);
		model.addAttribute("path", "Update");
		
		return "freeboard/freeBoardWrite";*/
	}
	
	@RequestMapping(value= "freeBoardUpdate", method = RequestMethod.POST)
	public void freeBoardUpdate(FreeBoardDTO freeBoardDTO, RedirectAttributes reAttributes) throws Exception{
		System.out.println("freeBoardUpdate Process Service");
		
		/*int result = freeBoardService.freeBoardUpdate(freeBoardDTO);
		String message = "Update Fail";
		if(result > 0){
			message = "Update Success";
		}
		reAttributes.addFlashAttribute("message", message);
		return "redirect:freeBoardView?num="+freeBoardDTO.getNum();*/
	}
	
	@RequestMapping(value= "freeBoardDelete", method = RequestMethod.GET)
	public void freeBoardDelete(Integer num, RedirectAttributes reAttributes) throws Exception{
		System.out.println("freeBoardDelete Service");
		
		/*int result = freeBoardService.freeBoardDelete(num);
		String message = "Delete Fail";
		if(result > 0){
			message = "Delete Success";
		}
		reAttributes.addFlashAttribute("message", message);
		return "redirect:freeBoardList";*/
	}
}
