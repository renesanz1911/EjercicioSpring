package Com.EjercicioSpring4.LaptopRepository;

import Com.EjercicioSpring4.LaptopEntity.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<LaptopEntity,Long> {
}
