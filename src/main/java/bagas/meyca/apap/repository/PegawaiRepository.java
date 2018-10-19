package bagas.meyca.apap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bagas.meyca.apap.entity.Instansi;
import bagas.meyca.apap.entity.Pegawai;

@Repository
public interface PegawaiRepository extends JpaRepository<Pegawai, Long>{
	Pegawai findByNip(String nip);
	List<Pegawai> findByInstansi(Instansi instansi);

}
