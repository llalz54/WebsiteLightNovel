package com.example.ServerBook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ServerBook.repository.RoleRepon;
import com.example.ServerBook.service.IRoleService;

@Service
public class RoleService implements IRoleService {
	@Autowired
	private RoleRepon roleRepon;

}
