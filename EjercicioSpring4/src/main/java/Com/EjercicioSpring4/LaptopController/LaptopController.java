package Com.EjercicioSpring4.LaptopController;

import Com.EjercicioSpring4.LaptopEntity.LaptopEntity;
import Com.EjercicioSpring4.LaptopRepository.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/laptops")
    public List<LaptopEntity> findAll(){
        return laptopRepository.findAll();
    }
    @PostMapping("/laptops")
    public LaptopEntity create(@RequestBody LaptopEntity laptop){
        return laptopRepository.save(laptop);
    }
}
