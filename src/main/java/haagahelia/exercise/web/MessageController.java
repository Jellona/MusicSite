/* The other part of REST backup method left in for fast implementation if needed */
package haagahelia.exercise.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import haagahelia.exercise.domain.Message;

@RestController
public class MessageController {

	/* Rest service */
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/hello")
    public Message msg(@RequestParam(value="name", defaultValue="World") String name) {
        return new Message(counter.incrementAndGet(), "Hello " +  name);
    }
	
}
