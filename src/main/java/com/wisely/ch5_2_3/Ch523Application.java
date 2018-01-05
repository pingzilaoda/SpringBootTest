package com.wisely.ch5_2_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wisely.ch5_2_3.UserRepository;
import com.wisely.ch5_2_3.UserTest;

import java.util.List;

@RestController
@SpringBootApplication
public class Ch523Application {

	@Autowired
	UserRepository userRepository;

	@RequestMapping("/save1")
	String save1(){
		UserTest userTest=userRepository.save(new UserTest("bbb",11,"bbb"));
		return userTest.toStrng();
	}

	@RequestMapping("/save2")
	int save2(){
		int num=userRepository.insertUserTest("ccc",22,"cccc");
		return num;
	}

	@RequestMapping("/delete")
	void delete(){
		UserTest userTest = new UserTest();
		userTest.setId(2);
		userRepository.delete(userTest);
	}

    @RequestMapping("/select1")
    String select1(){
		UserTest userTest=userRepository.findById(1);
		return userTest.toStrng();
	}

	@RequestMapping("/select2")
	String select2(){
		UserTest userTest=userRepository.withIdPatam(1);
		return userTest.toStrng();
	}

	@RequestMapping(value="/select3",produces={"application/json;chartset=UTF-8"})
    UserTest select3(){
		UserTest userTest=userRepository.withIdPatam(1);
		return userTest;
	}

	@RequestMapping(value="/update")
	int update(){
		int num=userRepository.setName("ccc",1);
		return num;
	}


	public static void main(String[] args) {
		SpringApplication.run(Ch523Application.class, args);
	}
}
