package com.demo.controllers.admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.demo.Dtos.Output.DataDashboard;
import com.demo.services.APIClient;
import com.demo.services.DashBoardAPIService;
import retrofit2.Response;

@Controller
@RequestMapping(value = { "", "admin/dashboard" })
public class DashBoardAdminController {
	
	DashBoardAPIService dashBoardAPIService = APIClient.getClient().create(DashBoardAPIService.class);
	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		try {

			Response<DataDashboard> response = dashBoardAPIService.getdata().execute();
			int statusCode = response.code();
			switch (statusCode) {
			case 400:
				return "errorpage/400page";
			case 401:
				return "admin/account/index";
			default:
				DataDashboard rs = response.body();
				modelMap.put("rs", rs);
				modelMap.put("feedback", rs.getFeedBackOutputs());	
				return "admin/dashboard/index";
			}
		} catch (Exception e) {
			return "errorpage/400page";
		}
	}
}
