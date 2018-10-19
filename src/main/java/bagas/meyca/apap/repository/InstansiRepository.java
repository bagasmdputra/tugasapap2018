package bagas.meyca.apap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bagas.meyca.apap.entity.Instansi;

@Repository
public interface InstansiRepository extends JpaRepository<Instansi, Long>{
}
