package com.SocialNetworkRestApp.RestController;

import java.util.ArrayList;

//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SocialNetworkBackEnd.Dao.BlogDao;
import com.SocialNetworkBackEnd.Model.Blog;
	
@RestController
public class BlogController {

	@Autowired
    BlogDao blogdao;
   
	@PostMapping(value="/addBlog")
    public ResponseEntity<String> saveblog(@RequestBody Blog b)
    {
      if(blogdao.addBlog(b))
      {
	    System.out.println(b);
        return new ResponseEntity<String>("blog added",HttpStatus.OK);
      }
      else
      {
	   return new ResponseEntity<String>(" error blog added",HttpStatus.INTERNAL_SERVER_ERROR);	
      }
    }
	@PostMapping(value="/getAllBlogs")
	public ResponseEntity<ArrayList<Blog>> getAllBlogs()
	{
		ArrayList listBlogs = (ArrayList)blogdao.getallblogs();
		return new ResponseEntity<ArrayList<Blog>>(listBlogs,HttpStatus.OK);
	}
	@PostMapping(value="/updateBlog")
	public  ResponseEntity<String> updateBlog(@RequestBody Blog blog)
	{
		Blog tempBlog=blogdao.getblogbyid(blog.getBlogId());
		
		
		
		tempBlog.setBlogName(blog.getBlogName());
		tempBlog.setBlogContent(blog.getBlogContent());
		if(blogdao.updateblog(tempBlog))
		{
			return new ResponseEntity<String>("Blog Update",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Blog updation",HttpStatus.SERVICE_UNAVAILABLE);
			
		}
	}
	@PostMapping(value = "deleteBlog")
	public ResponseEntity<String> deleteBlog(@RequestBody Blog blog)
	{
		Blog tempblog=blogdao.getblogbyid(blog.getBlogId());
		if(blogdao.deleteblog(tempblog))
		{
			return new ResponseEntity<String>("Blog Deleted",HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("Error in blog deletion",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}


}

	

