package com.cs.online_bank.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.online_bank.admin.dao.LoanMapper;
import com.cs.online_bank.admin.dao.StoreMapper;
import com.cs.online_bank.admin.model.Loan;
import com.cs.online_bank.admin.model.LoanProve;
import com.cs.online_bank.admin.service.LoanService;
import com.cs.online_bank.admin.vo.LoanRegister;
@Service
@Transactional
public class LoanServiceImpl implements LoanService{
	@Autowired
	private LoanMapper loanMapper;
	@Autowired
	private StoreMapper storeMapper;
	@Override
	public List<Loan> findLoanById(Integer id) {
		return loanMapper.findLoanById(id);
	}
	
	@Override
	public void saveLoan(LoanRegister loanRegister) {	
		loanMapper.saveLoan(loanRegister);
	}
	@Override
	public void updateLoan(Loan loan) {
		loanMapper.updateLoan(loan);
	}

	@Override
	public List<Map<String, Object>> findLoanAll() {
		return loanMapper.findLoanAll();
	}

	@Override
	public void saveProve(LoanProve loanProve) {
		loanMapper.saveProve(loanProve);
	}

	
	
}
