package com.cs.online_bank.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cs.online_bank.admin.model.Loan;
import com.cs.online_bank.admin.model.LoanProve;
import com.cs.online_bank.admin.vo.LoanRegister;

@Mapper
public interface LoanMapper {
	//根据id查找贷款记录
	public List<Loan> findLoanById(Integer id);
	//查找所有贷款记录
	public List<Map<String, Object>> findLoanAll();
	//添加贷款
	public void saveLoan(LoanRegister loanRegister);
	//修改贷款
	public void updateLoan(Loan loan);
	//添加贷款证明
	public void saveProve(LoanProve loanProve);

}
