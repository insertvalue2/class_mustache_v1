package com.tenco.class_mustache.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tenco.model.Member;

@Controller
public class IndexController {

	// 작업 1
	// 정적파일 생성 위치 및 개념 설명하기

	// 작업 2
	// context root 를 설정하지 않음
	/**
	 * 주소설계 - http://localhost:8080, http://localhost:8080/
	 * 
	 * @param Model (뷰 쪽으로 데이터를 전달하기 위함)
	 * @return index.mustache
	 */
	@GetMapping({ "", "/" })
	public String temp1(Model model) {

		// 뷰 쪽으로 내려줄 데이터를 만들어 보자.
		String name = "길동";
		int age = 22;
		String password = "1234";
		String email = "<b>a@naver.com</b>";
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("password", password);
		model.addAttribute("email", email);

		// viewResolver 동작
		// src/main/resources/templates/index.mustache 찾음
		return "index";
	}

	// 주소설계 - http://localhost:8080/layout
	@GetMapping("/layout")
	public String layout() {
		return "main";
	}

	// 주소설계 - http://localhost:8080/model/data
	@GetMapping("/model/data")
	public String modelData(Model model) {

		Member member = Member.builder()
				.id(1)
				.username("티모")
				.phone("01012341234")
				.build();
		model.addAttribute("member", member);

		return "model-data";
	}

	// 주소설계 - http://localhost:8080/model/array
	@GetMapping("/model/array")
	public String modelArray(Model model) { 
		Member member1 = Member.builder()
				.id(2)
				.username("길동")
				.phone("01022223333")
				.build();

		Member member2 = Member.builder()
				.id(3)
				.username("순신")
				.phone("01033334444")
				.build();

		List<Member> members = new ArrayList<>();
		members.add(member1);
		members.add(member2);
		model.addAttribute("members", members);
		model.addAttribute("user", true);

		return "model-data-array";
	}

}
