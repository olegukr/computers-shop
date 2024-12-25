package factoriaf5.computers_shop;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

class ComputerServiceTest {

    @Mock
    private ComputerRepository computerRepository;

    @InjectMocks
    private ComputerService computerService;

    private Computer computer1;
    private Computer computer2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        computer1 = new Computer("Apple MacBook Pro", 16, "M1 Pro", "macOS", 1999.99, 5, null);
        computer1.setId(1L);

        computer2 = new Computer("Dell XPS 13", 8, "Intel i7", "Windows 11", 1499.99, 3, null);
        computer2.setId(2L);
    }

    @Test
    void testGetAllComputers() {
        List<Computer> computers = Arrays.asList(computer1, computer2);
        when(computerRepository.findAll()).thenReturn(computers);

        List<Computer> result = computerService.getAllComputers();

        assertThat(result).hasSize(2);
        assertThat(result).contains(computer1, computer2);

        verify(computerRepository, times(1)).findAll();
    }

    @Test
    void testGetComputerById() {
        when(computerRepository.findById(1L)).thenReturn(Optional.of(computer1));

        Computer result = computerService.getComputerById(1L);

        assertThat(result).isEqualTo(computer1);

        verify(computerRepository, times(1)).findById(1L);
    }

    @Test
    void testGetComputerByIdNotFound() {
        when(computerRepository.findById(3L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> computerService.getComputerById(3L));

        assertThat(exception.getMessage()).isEqualTo("Computer not found with id: 3");

        verify(computerRepository, times(1)).findById(3L);
    }

    @Test
    void testAddComputer() {
        when(computerRepository.save(computer1)).thenReturn(computer1);

        Computer result = computerService.addComputer(computer1);

        assertThat(result).isEqualTo(computer1);

        verify(computerRepository, times(1)).save(computer1);
    }

    @Test
    void testUpdateComputer() {
        when(computerRepository.findById(1L)).thenReturn(Optional.of(computer1));
        when(computerRepository.save(any(Computer.class))).thenReturn(computer1);

        Computer updatedComputer = new Computer("Updated Brand", 32, "Updated Processor", "Updated OS", 2999.99, 10, null);

        Computer result = computerService.updateComputer(1L, updatedComputer);

        assertThat(result.getBrand()).isEqualTo("Updated Brand");
        assertThat(result.getMemory()).isEqualTo(32);
        assertThat(result.getProcessorFeatures()).isEqualTo("Updated Processor");
        assertThat(result.getOperatingSystem()).isEqualTo("Updated OS");
        assertThat(result.getPrice()).isEqualTo(2999.99);
        assertThat(result.getQuantity()).isEqualTo(10);

        verify(computerRepository, times(1)).findById(1L);
        verify(computerRepository, times(1)).save(any(Computer.class));
    }

    @Test
    void testDeleteComputer() {
        when(computerRepository.existsById(1L)).thenReturn(true);

        computerService.deleteComputer(1L);

        verify(computerRepository, times(1)).deleteById(1L);
    }
}
