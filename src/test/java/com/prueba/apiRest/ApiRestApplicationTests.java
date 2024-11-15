package com.prueba.apiRest;

import com.prueba.apiRest.dto.PeopleAllInfoDto;
import com.prueba.apiRest.dto.PeopleLowInfoDto;
import com.prueba.apiRest.dto.PeopleQueryDto;
import com.prueba.apiRest.model.People;
import com.prueba.apiRest.service.PeopleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
class ApiRestApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PeopleService peopleService;

	@Test
	public void contextLoads() {
		assertNotNull(peopleService);
	}

	@Test
	public void testgetAllLowPeoplesCorrect(){
		PeopleQueryDto peopleQueryDto = new PeopleQueryDto();
		peopleQueryDto.setDocumentNumber(10121314L);
		peopleQueryDto.setTypeDocument("C");
		final List<PeopleAllInfoDto> response = peopleService.findPeopleByDocumentNumber(
				peopleQueryDto.getDocumentNumber(),
				peopleQueryDto.getTypeDocument());
		Assertions.assertEquals(response.get(0).getFirstName(),"Juan");
	}
	@Test
	public void testgetAllLowPeoplesFaild(){
		PeopleQueryDto peopleQueryDto = new PeopleQueryDto();
		peopleQueryDto.setDocumentNumber(10121320L);
		peopleQueryDto.setTypeDocument("T");
		final List<PeopleAllInfoDto> response = peopleService.findPeopleByDocumentNumber(
				peopleQueryDto.getDocumentNumber(),
				peopleQueryDto.getTypeDocument());
		Assertions.assertNotEquals(response.get(0),"Juan");
	}
	@Test
	public void testGetPersonByDocumentNumber_Found() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/Peoples/")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{ \"documentNumber\": 10121314, \"typeDocument\": \"C\"}"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("Juan"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].middleName").value("Carlos"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].documentNumber").value(10121314));
	}
	@Test
	public void testGetPersonByDocumentNumber_NotFound() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/Peoples/")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{ \"documentNumber\": 10121314, \"typeDocument\": \"PP\"}"))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.content().string("El Tipo de documento no es valido"));
	}


}
