package com.cs.online_bank.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.online_bank.admin.http.HttpResult;
import com.cs.online_bank.admin.model.Loan;
import com.cs.online_bank.admin.model.LoanProve;
import com.cs.online_bank.admin.model.User;
import com.cs.online_bank.admin.service.LoanService;
import com.cs.online_bank.admin.service.UserService;
import com.cs.online_bank.admin.vo.LoanRegister;

@RestController("/loan")
public class LoanController {
	@Autowired
	private LoanService loanService;
	@Autowired 
	private UserService userService;
	//根据id查找贷款记录
	@GetMapping("/findLoanById")
	public HttpResult findLoanById(Integer id) {
		List<Loan> findLoanById = loanService.findLoanById(id);
		if(findLoanById==null) {
			return HttpResult.ok("还没有申请过贷款");
		}
		return HttpResult.ok(findLoanById);
	}
	//添加贷款记录
	@PostMapping("/saveLoan")
	public HttpResult saveLoan(LoanRegister loanRegister) {
		User user = userService.findById(loanRegister.getuId());
		if(user.getRealName()!=loanRegister.getRealName()) {
			return HttpResult.error(201,"真实姓名有误,添加失败");
		}
		if(user.getIdNumber()!=loanRegister.getIdNumber()) {
			return HttpResult.error(201,"身份证号有误，添加失败");
		}
		loanService.saveLoan(loanRegister);
		return HttpResult.ok("添加成功");
	}
	//添加贷款处理记录
	@PostMapping("/saveProve")
	public HttpResult saveProve(LoanProve loanProve) {
		//先添加记录
		loanService.saveProve(loanProve);
		//再修改贷款表，表示 已添加
		Loan loan=new Loan();
		loan.setId(loanProve.getbId());
		loan.setWhetherProve(1);
		loanService.updateLoan(loan);
		return HttpResult.ok("添加成功");
	}
	//审核通过
	@PutMapping("/loanSuccess")
	public HttpResult loanSuccess(Loan loan) {
		loan.setStatus(1);
		loanService.updateLoan(loan);
		//接着放款以及生成还款账单
		
		return HttpResult.ok("审核通过");
	}
	//审核未通过
	@PutMapping("/loanFail")
	public HttpResult loanFail(Loan loan) {
		loan.setStatus(2);
		loanService.updateLoan(loan);
		return HttpResult.ok("审核失败"); 
	}
	//查询所有的贷款记录
	@GetMapping("/findLoanAll")
	public HttpResult findLoanAll() {
		List<Map<String, Object>> findLoanAll = loanService.findLoanAll();
		if(findLoanAll==null) {
			return HttpResult.ok("暂时还没有贷款记录");
		}
		return HttpResult.ok(findLoanAll);
	}
	
	
}
