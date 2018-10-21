package bagas.meyca.apap.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bagas.meyca.apap.entity.Instansi;
import bagas.meyca.apap.repository.InstansiRepository;
import bagas.meyca.apap.service.InstansiService;

@Service
@Transactional
public class InstansiImplementation implements InstansiService {

	@Autowired
	private InstansiRepository instansiDB;
	
	@Override
	public Instansi get(Long id) {
		return instansiDB.getOne(id);
	}

	@Override
	public List<Instansi> getAll() {
		return instansiDB.findAll();
	}

	@Override
	public Instansi add(Instansi object) {
		return instansiDB.save(object);
	}

	@Override
	public Instansi update(Instansi object) {
		Instansi instansi = get(object.getId());
		instansi.setNama(object.getNama());
		instansi.setDeskripsi(object.getDeskripsi());
		instansi.setProvinsi(object.getProvinsi());
		return instansiDB.save(instansi);
	}

	@Override
	public Instansi delete(Long id) {
		Instansi instansi = get(id);
		instansiDB.delete(instansi);
		return instansi;
	}
	
}
