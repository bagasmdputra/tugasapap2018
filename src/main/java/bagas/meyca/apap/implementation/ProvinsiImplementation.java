package bagas.meyca.apap.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bagas.meyca.apap.entity.Provinsi;
import bagas.meyca.apap.repository.ProvinsiRepository;
import bagas.meyca.apap.service.ProvinsiService;

@Service
@Transactional
public class ProvinsiImplementation implements ProvinsiService {

	@Autowired
	private ProvinsiRepository provinsiDB;
	
	@Override
	public Provinsi get(Long id) {
		return provinsiDB.getOne(id);
	}

	@Override
	public List<Provinsi> getAll() {
		return provinsiDB.findAll();
	}

	@Override
	public Provinsi add(Provinsi object) {
		return provinsiDB.save(object);
	}

	@Override
	public Provinsi update(Provinsi object) {
		Provinsi provinsi = get(object.getId());
		provinsi.setNama(object.getNama());
		provinsi.setTunjangan(object.getTunjangan());
		return provinsiDB.save(provinsi);
	}

	@Override
	public Provinsi delete(Long id) {
		Provinsi provinsi = get(id);
		provinsiDB.delete(provinsi);
		return provinsi;
	}
	
}
