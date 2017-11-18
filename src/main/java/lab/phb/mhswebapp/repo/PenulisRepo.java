package lab.phb.mhswebapp.repo;

import lab.phb.mhswebapp.entity.Penulis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenulisRepo 
        extends JpaRepository<Penulis,String>{
}
