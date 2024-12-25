package factoriaf5.computers_shop;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ComputerService {

    private final ComputerRepository computerRepository;

    public ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    public Computer getComputerById(Long id) {
        return computerRepository.findById(id).orElseThrow(() -> new RuntimeException("Computer not found with id: " + id));
    }

    public Computer addComputer(Computer computer) {
        return computerRepository.save(computer);
    }

    public Computer updateComputer(Long id, Computer updatedComputer) {
        Computer existingComputer = getComputerById(id);
        existingComputer.setBrand(updatedComputer.getBrand());
        existingComputer.setMemory(updatedComputer.getMemory());
        existingComputer.setProcessorFeatures(updatedComputer.getProcessorFeatures());
        existingComputer.setOperatingSystem(updatedComputer.getOperatingSystem());
        existingComputer.setPrice(updatedComputer.getPrice());
        existingComputer.setQuantity(updatedComputer.getQuantity());
        existingComputer.setShop(updatedComputer.getShop());
        return computerRepository.save(existingComputer);
    }

    public void deleteComputer(Long id) {
        computerRepository.deleteById(id);
    }
}
