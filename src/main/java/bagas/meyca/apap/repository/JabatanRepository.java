package bagas.meyca.apap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bagas.meyca.apap.entity.Jabatan;

@Repository
public interface JabatanRepository extends JpaRepository<Jabatan, Long>{
	Jabatan getJabatanByid(Long id);
}