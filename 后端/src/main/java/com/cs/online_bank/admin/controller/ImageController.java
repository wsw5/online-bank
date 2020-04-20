package com.cs.online_bank.admin.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cs.online_bank.admin.http.HttpResult;

@RestController("/image")
public class ImageController {
	@PostMapping("/upload")
	public HttpResult imageUpload(HttpServletRequest request,MultipartFile file) throws Exception {
		System.out.println(request);
		System.out.println("图片");
		//获取文件名字
		String fileName = file.getOriginalFilename();
		//截取文件后缀
		String extName=fileName.substring(fileName.lastIndexOf("."));
		//时间戳
		String time=System.currentTimeMillis()+"";
		//文件新名字
		String newName=time+extName;
		//绝对路径
		String path = System.getProperty("user.dir");
		File file1=new File(path+"/src/main/resources/static/imageUpload");
		if(!file1.isDirectory()) {
			file1.mkdirs();
		}
		File fileImg=new File(file1,newName);
		file.transferTo(fileImg);
		String filepath=
				//http协议
				request.getScheme()+"://"+
				//服务器名称
				request.getServerName()+":"+
				//端口号
				request.getServerPort()+"/static/imageUpload/"+newName;
		return HttpResult.ok(filepath);
	}
}
