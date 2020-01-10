/*
 * AuthenticatedConsumerController.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.employer.applications;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.applications.Applications;
import acme.entities.roles.Employer;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/applications/")
public class EmployerApplicationController extends AbstractController<Employer, Applications> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EmployerApplicationListMineService	employerMineService;

	@Autowired
	private EmployerApplicationShowService		showService;
	// Constructors -----------------------------------------------------------

	@Autowired
	private EmployerApplicationUpdateService	updateService;


	@PostConstruct
	private void initialise() {

		//super.addCustomCommand(CustomCommand.EMPLOYER_LIST_MINE, BasicCommand.LIST, this.employerListMineService);
		super.addCustomCommand(CustomCommand.LIST_APPLICATIONS, BasicCommand.LIST, this.employerMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
	}

}
