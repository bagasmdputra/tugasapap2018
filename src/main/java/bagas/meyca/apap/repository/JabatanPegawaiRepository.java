package bagas.meyca.apap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bagas.meyca.apap.entity.Jabatan;
import bagas.meyca.apap.entity.JabatanPegawai;
import bagas.meyca.apap.entity.Pegawai;

@Repository
public interface JabatanPegawaiRepository extends JpaRepository<JabatanPegawai, Long> {
	
	List<JabatanPegawai> findByPegawai(Pegawai pegawai);
	List<JabatanPegawai> findByJabatan(Jabatan jabatan);
}