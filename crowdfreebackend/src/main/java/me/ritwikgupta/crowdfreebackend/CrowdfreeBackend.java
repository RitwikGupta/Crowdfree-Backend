package me.ritwikgupta.crowdfreebackend;

import static spark.Spark.*;



import java.util.ArrayList;
import java.util.Arrays;import java.util.LinkedList;
import java.util.Queue;


public class CrowdfreeBackend {
	
    public static void main(String[] args) {
    	
    	Queue<Integer> chipotle = new LinkedList<Integer>();
    	Queue<Integer> starbucks = new LinkedList<Integer>();
    	Queue<Integer> union = new LinkedList<Integer>();
    	
    	chipotle.add(1);
    	starbucks.add(1);
    	union.add(1);
    	
    	get("/:name", (req, res) -> {
    		String name = req.params(":name");
    		if(name.equals("chipotle")){
    			int avg = 0;
    			for(Integer e : chipotle){
    				avg += e;
    			}
    			return Math.round(avg/(float) chipotle.size());
    		} else if(name.equals("starbucks")){
    			int avg = 0;
    			for(Integer e : starbucks){
    				avg += e;
    			}
    			return Math.round(avg/(float) starbucks.size());
    		} else if(name.equals("union")){
    			int avg = 0;
    			for(Integer e : union){
    				avg += e;
    			}
    			return Math.round(avg/(float) union.size());
    		}
    		return "Invalid choice";
    	});
    	
        post("/upload/:name", (req, res) -> {
        	String name = req.params(":name");
        	int body = Integer.parseInt(req.body());
        	
        	if(name.equals("chipotle")){
        		if(chipotle.size() > 2){
        			chipotle.remove();
        		}
        		chipotle.add(body);
        		System.out.println(body);
        	} else if(name.equals("starbucks")){
        		if(starbucks.size() > 2){
        			starbucks.remove();
        		}
        		starbucks.add(body);
        		System.out.println(body);
        	} else if(name.equals("union")){
        		if(union.size() > 2){
        			union.remove();
        		}
        		union.add(body);
        		System.out.println(body);
        	}
        	
        	return body;
        });
    }

}
