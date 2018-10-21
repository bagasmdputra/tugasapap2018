package bagas.meyca.apap.implementation;

import java.text.SimpleDateFormat;
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
		return pegawaiDB.getOne(id);
	}

	@Override
	public List<Pegawai> getAll() {
		return pegawaiDB.findAll();
	}

	@Override
	public Pegawai add(Pegawai object) {
		object.setNip(generateNip(object));
		return pegawaiDB.save(object);
	}

	@Override
	public Pegawai update(Pegawai object) {
		Pegawai pegawai = get(object.getId());
		pegawai.setNama(object.getNama());
		pegawai.setInstansi(object.getInstansi());
		pegawai.setListJabatan(object.getListJabatan());
		pegawai.setTahunMasuk(object.getTahunMasuk());
		pegawai.setTanggalLahir(object.getTanggalLahir());
		pegawai.setTempatLahir(object.getTempatLahir());
		pegawai.setNip(generateNip(object));
		return pegawaiDB.save(pegawai);
	}

	@Override
	public Pegawai delete(Long id) {
		Pegawai pegawai = get(id);
		pegawaiDB.delete(pegawai);
		return pegawai;
	}

	@Override
	public Pegawai getByNip(String nip) {
		return pegawaiDB.findByNip(nip);
	}
	

	private String generateNip(Pegawai object) {
		SimpleDateFormat f = new SimpleDateFormat("ddMMyy");
		int urutan = 1;
		
		String kodeInstansi = object.getInstansi().getId().toString();
		String kodeProvinsi = object.getInstansi().getProvinsi().getId().toString();
		String tanggalLahir = f.format(object.getTanggalLahir());
		String tahunSekarang = object.getTahunMasuk();
		String urutanString = String.format("%02d", ""+urutan);
		
		String nip = kodeInstansi + kodeProvinsi + tanggalLahir + tahunSekarang;
		while (!getByNip(nip + urutanString).equals(null)) {
			urutan++;
			urutanString = String.format("%02d", ""+urutan);
		}
		return nip + urutanString;
	}

}
