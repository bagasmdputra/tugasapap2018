package bagas.meyca.apap.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bagas.meyca.apap.entity.JabatanPegawai;
import bagas.meyca.apap.repository.JabatanPegawaiRepository;
import bagas.meyca.apap.service.JabatanPegawaiService;

@Service
@Transactional
public class JabatanPegawaiImplementation implements JabatanPegawaiService {

	@Autowired
	private JabatanPegawaiRepository jabatanPegawaiDB;
	
	@Override
	public JabatanPegawai get(Long id) {
		return jabatanPegawaiDB.getOne(id);
	}

	@Override
	public List<JabatanPegawai> getAll() {
		return jabatanPegawaiDB.findAll();
	}

	@Override
	public JabatanPegawai add(JabatanPegawai object) {
		return jabatanPegawaiDB.save(object);
	}

	@Override
	public JabatanPegawai update(JabatanPegawai object) {
		JabatanPegawai jabatanPegawai = get(object.getId());
		jabatanPegawai.setJabatan(object.getJabatan());
		jabatanPegawai.setPegawai(object.getPegawai());
		return jabatanPegawaiDB.save(jabatanPegawai);
	}

	@Override
	public JabatanPegawai delete(Long id) {
		JabatanPegawai jabatanPegawai = get(id);
		jabatanPegawaiDB.delete(jabatanPegawai);
		return jabatanPegawai;
	}
	
	
}
