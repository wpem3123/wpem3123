package site.metacoding.white;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// 데이터 받기 
// GET ->  http body 가 없음 -> QueryString,PathVariable(PK) -> Form (GET) -> 브라우저 (주소뒤 ? 붙이기) 
// POST, PUT -> http body 담아준다. -> Form(POST) -> JS 
// DELETE -> http body 가 없음 -> QueryString,PathVariable(PK)



@RestController
public class SecondController {
	@GetMapping("/second/{id}") // PK(id)가 1인 것 
	public String getData(@PathVariable Integer id) {
		return "id : "+id;
	}
	
	
	//QueryString = x-www-form 타입이다.
	@GetMapping("/second") 
	public String getData2(String title,String content) {
		return "title :"+title+", content :"+content;
	}
	
	// BR -> title=제목&content=내용, content-type x-www 머시기 가 있어야 파싱이 가능 
	@PostMapping("/second")
		public String postData(String title,String content) {  // 스프링 파싱 기본전략 : x-www-form-머시기 
			return "title:"+title+", content " +content; // body에 담아서 보내줘야함.
		}
	@DeleteMapping("/second/{id}") 
	public String deleteData(@PathVariable Integer id) {  
		return id+"delete ok"; // 
	}
}

