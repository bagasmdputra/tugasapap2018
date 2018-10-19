package bagas.meyca.apap.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bagas.meyca.apap.entity.Pegawai;
import bagas.meyca.apap.repository.PegawaiRepository;
import bagas.meyca.apap.service.PegawaiService;

@Service
@Transactional
public class PegawaiImplementation implements PegawaiService{

	@Autowired
	private PegawaiRepository pegawaiDB;
	
	@Override
	public Pegawai get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pegawai> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pegawai add(Pegawai object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pegawai update(Pegawai object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pegawai delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pegawai getByNip(String nip) {
		return pegawaiDB.findByNip(nip);
	}
	
}
