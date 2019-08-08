package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskiesByYear(){
		List<Whisky> found = whiskyRepository.findWhiskiesByYear(1991);
		assertEquals(new Long(2),found.get(0).getId());
	}

	@Test
	public void canFindMultipleWhiskiesByYear(){
		List<Whisky> found = whiskyRepository.findWhiskiesByYear(2018);
		assertEquals(2, found.size());
	}

	@Test
	public void canFindDistilleriesByRegion(){
		List<Distillery> found = distilleryRepository.findDistilleriesByRegion("Lowland");
		assertEquals(new Long(2), found.get(0).getId());
	}

	@Test public void canFindMultipleDistilleriesByRegion() {
		List<Distillery> found = distilleryRepository.findDistilleriesByRegion("Speyside");
		assertEquals(2, found.size());
	}

//	@Test public void canFindWhiskiesByAge(){
//		List<Whisky> found = whiskyRepository.findWhiskiesThatHaveDistilleryNameAndWhiskyAge(12);
//		assertEquals(new Long(2), found.get(0).getId());
//	}

//	@Test public void canFindWhiskiesByDistillery(){
//		List<Whisky> found = whiskyRepository.findWhiskiesThatHaveDistilleryNameAndWhiskyAge("Macallan");
//		assertEquals(new Long(3), found.get(0).getId());
//	}

	@Test public void canFindWhiskiesByDistilleryAndAge(){
		List<Whisky> found = whiskyRepository.findWhiskiesThatHaveDistilleryNameAndWhiskyAge("Glendronach", 15);
		assertEquals(new Long(1), found.get(0).getId());
	}

	@Test
	public void canFindWhiskiesByRegion(){
		List<Whisky> found = whiskyRepository.findWhiskiesByRegion("Highland");
		assertEquals(new Long(1), found.get(0).getId());
		assertEquals(new Long(4), found.get(1).getId());
	}

	@Test
	public void canFindDistilleriesWith12YOWhiskies(){
		List<Distillery> found = distilleryRepository.findDistilleriesWith12YOWhiskies();
		assertEquals(2, found.size());
	}
}
