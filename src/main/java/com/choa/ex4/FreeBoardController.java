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
		List<BoardDTO> freeBoardList = freeBoardService.boardList(curPage);
		model.addAttribute("boardList", freeBoardList).addAttribute("board", "freeBoard");		
		return "board/boardList";
	}
	
	@RequestMapping(value= "freeBoardView", method = RequestMethod.GET)
	public String freeBoardView(Model model, Integer num) throws Exception{
		BoardDTO boardDTO = freeBoardService.boardView(num);		
		model.addAttribute("boardDTO", boardDTO).addAttribute("board", "freeBoard");
		return "board/boardView";
	}
	
	@RequestMapping(value= "freeBoardWrite", method = RequestMethod.GET)
	public String freeBoardWrite(Model model){
		model.addAttribute("path", "Write").addAttribute("board", "freeBoard");
		return "board/boardWrite";
	}
	
	@RequestMapping(value= "freeBoardWrite", method = RequestMethod.POST)
	public String freeBoardWrite(FreeBoardDTO freeBoardDTO, RedirectAttributes reAttributes) throws Exception{
		int result = freeBoardService.boardWrite(freeBoardDTO);
		String message = "Write Fail";
		if(result > 0){
			message = "Write Success";
		}
		reAttributes.addFlashAttribute("message", message);
		return "redirect:freeBoardList";
	}
	
	@RequestMapping(value= "freeBoardUpdate", method = RequestMethod.GET)
	public String freeBoardUpdate(Model model, Integer num) throws Exception{
		BoardDTO boardDTO = freeBoardService.boardView(num);
		model.addAttribute("boardDTO", boardDTO).addAttribute("path", "Update").addAttribute("board", "freeBoard");
		return "board/boardWrite";
	}
	
	@RequestMapping(value= "freeBoardUpdate", method = RequestMethod.POST)
	public String freeBoardUpdate(FreeBoardDTO freeBoardDTO, RedirectAttributes reAttributes) throws Exception{
		int result = freeBoardService.boardUpdate(freeBoardDTO);
		String message = "Update Fail";
		if(result > 0){
			message = "Update Success";
		}
		reAttributes.addFlashAttribute("message", message);
		return "redirect:freeBoardView?num="+freeBoardDTO.getNum();
	}
	
	@RequestMapping(value= "freeBoardDelete", method = RequestMethod.GET)
	public String freeBoardDelete(Integer num, RedirectAttributes reAttributes) throws Exception{
		int result = freeBoardService.boardDelete(num);
		String message = "Delete Fail";
		if(result > 0){
			message = "Delete Success";
		}
		reAttributes.addFlashAttribute("message", message);
		return "redirect:freeBoardList";
	}
	
	@RequestMapping(value= "freeBoardReply", method = RequestMethod.GET)
	public String freeBoardReply(Model model, Integer num){
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(num);
		model.addAttribute("boardDTO", boardDTO).addAttribute("path", "Reply").addAttribute("board", "freeBoard");
		return "board/boardWrite";
	}
	
	@RequestMapping(value= "freeBoardReply", method = RequestMethod.POST)
	public String freeBoardReply(FreeBoardDTO freeBoardDTO, RedirectAttributes reAttributes) throws Exception{
		int result = freeBoardService.boardReply(freeBoardDTO);
		String message = "Reply Fail";
		if(result > 0){
			message = "Reply Success";
		}
		reAttributes.addFlashAttribute("message", message);
		return "redirect:freeBoardList";
	}
}
