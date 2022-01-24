package com.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.demo.Dtos.Output.DataDashboard;
import com.demo.services.IDashBoardService;

@RequestMapping("api/dashboard")
@RestController
public class DashboardController {
	@Autowired
	private IDashBoardService dashBoardService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<DataDashboard> getData() {
		return new ResponseEntity<DataDashboard>(dashBoardService.getData(),HttpStatus.OK);
	}
}
