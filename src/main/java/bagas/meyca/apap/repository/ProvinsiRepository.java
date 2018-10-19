package bagas.meyca.apap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bagas.meyca.apap.entity.Provinsi;

@Repository
public interface ProvinsiRepository extends JpaRepository<Provinsi, Long>{
	
}