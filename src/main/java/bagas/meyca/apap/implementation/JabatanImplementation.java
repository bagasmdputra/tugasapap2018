package bagas.meyca.apap.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bagas.meyca.apap.entity.Jabatan;
import bagas.meyca.apap.repository.JabatanRepository;
import bagas.meyca.apap.service.JabatanService;

@Service
@Transactional
public class JabatanImplementation implements JabatanService {

	@Autowired
	private JabatanRepository jabatanDB;
	
	@Override
	public Jabatan get(Long id) {
		return jabatanDB.getJabatanByid(id);
	}

	@Override
	public List<Jabatan> getAll() {
		return jabatanDB.findAll();
	}

	@Override
	public Jabatan add(Jabatan object) {
		return jabatanDB.save(object);
	}

	@Override
	public Jabatan update(Jabatan object) {
		return jabatanDB.save(object);
	}

	@Override
	public Jabatan delete(Long id) {
		Jabatan jabatan = get(id);
		jabatanDB.delete(jabatan);
		return jabatan;
	}
	
}
