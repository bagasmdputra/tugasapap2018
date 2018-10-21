package bagas.meyca.apap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bagas.meyca.apap.entity.JabatanPegawai;

@Repository
public interface JabatanPegawaiRepository extends JpaRepository<JabatanPegawai, Long> {
	
}