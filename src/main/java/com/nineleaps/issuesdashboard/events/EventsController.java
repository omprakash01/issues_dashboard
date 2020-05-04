package com.nineleaps.issuesdashboard.events;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nineleaps.issuesdashboard.github.GithubClient;
import com.nineleaps.issuesdashboard.github.RepositoryEvents;

@Controller
public class EventsController {
	private final GithubClient githubClient;

	private final GithubProjectRepository repository;

	public EventsController(GithubClient githubClient, GithubProjectRepository repository) {
		this.githubClient = githubClient;
		this.repository = repository;
	}
	
	@GetMapping("/events/{projectName}")
	@ResponseBody
	public RepositoryEvents[] fetchEvents(@PathVariable String projectName) {
		GithubProject project = this.repository.findByRepoName(projectName);
		return this.githubClient.fetchEvents(project.getOrgName(), project.getRepoName()).getBody();
	}

}
