package com.SocialNetworkRestApp.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SocialNetworkBackEnd.Dao.JobDao;
import com.SocialNetworkBackEnd.Model.Job;


@RestController
public class JobController {

	@Autowired
    JobDao jobdao;
   
	@PostMapping(value="/addjob")
    public ResponseEntity<String> saveblog(@RequestBody Job b)
    {
      if(jobdao.addjob(b))
      {
	    System.out.println(b);
        return new ResponseEntity<String>("Job added",HttpStatus.OK);
      }
      else
      {
	   return new ResponseEntity<String>(" error job added",HttpStatus.INTERNAL_SERVER_ERROR);	
      }
    }
}
