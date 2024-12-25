package factoriaf5.computers_shop;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ComputerController.class)
class ComputerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ComputerService computerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllComputers() throws Exception {
        List<Computer> computers = Arrays.asList(
                new Computer("Apple MacBook Pro", 16, "M1 Pro", "macOS", 1999.99, 5, null),
                new Computer("Dell XPS 13", 8, "Intel i7", "Windows 11", 1499.99, 3, null)
        );

        when(computerService.getAllComputers()).thenReturn(computers);

        mockMvc.perform(get("/api/computers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].brand").value("Apple MacBook Pro"))
                .andExpect(jsonPath("$[1].brand").value("Dell XPS 13"));
    }

    @Test
    public void testGetComputerById() throws Exception {
        Computer computer = new Computer();
        computer.setId(1L);
        computer.setBrand("Apple MacBook Pro");
        computer.setMemory(16);
        computer.setProcessorFeatures("M1 Pro");
        computer.setOperatingSystem("macOS");
        computer.setPrice(1999.99);
        computer.setQuantity(5);

        when(computerService.getComputerById(anyLong())).thenReturn(computer);

        mockMvc.perform(get("/api/computers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.brand").value("Apple MacBook Pro"))
                .andExpect(jsonPath("$.memory").value(16))
                .andExpect(jsonPath("$.processorFeatures").value("M1 Pro"))
                .andExpect(jsonPath("$.operatingSystem").value("macOS"))
                .andExpect(jsonPath("$.price").value(1999.99))
                .andExpect(jsonPath("$.quantity").value(5));

        verify(computerService).getComputerById(anyLong());
    }

    @Test
    void testAddComputer() throws Exception {
        Computer computer = new Computer("Apple MacBook Pro", 16, "M1 Pro", "macOS", 1999.99, 5, null);

        when(computerService.addComputer(Mockito.any(Computer.class))).thenReturn(computer);

        mockMvc.perform(post("/api/computers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(computer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand").value("Apple MacBook Pro"))
                .andExpect(jsonPath("$.memory").value(16))
                .andExpect(jsonPath("$.price").value(1999.99));
    }

    @Test
    public void testUpdateComputer() throws Exception {
        Computer computer = new Computer();
        when(computerService.updateComputer(anyLong(), any(Computer.class))).thenReturn(computer);

        mockMvc.perform(put("/api/computers/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(computer)))
                .andExpect(status().isOk());

        verify(computerService).updateComputer(anyLong(), any(Computer.class));
    }

    @Test
    public void testDeleteComputer() throws Exception {
        mockMvc.perform(delete("/api/computers/1"))
                .andExpect(status().isOk());

        verify(computerService).deleteComputer(anyLong());
    }
}
