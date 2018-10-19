package bagas.meyca.apap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bagas.meyca.apap.entity.Instansi;
import bagas.meyca.apap.entity.Jabatan;
import bagas.meyca.apap.entity.JabatanPegawai;
import bagas.meyca.apap.entity.Pegawai;
import bagas.meyca.apap.entity.Provinsi;
import bagas.meyca.apap.service.InstansiService;
import bagas.meyca.apap.service.JabatanService;
import bagas.meyca.apap.service.PegawaiService;
import bagas.meyca.apap.service.ProvinsiService;

@Controller
public class PegawaiController {
	
	@Autowired
	private PegawaiService pegawaiService;
	
	@Autowired
	private ProvinsiService provinsiService;
	
	@Autowired
	private JabatanService jabatanService;
	
	@Autowired
	private InstansiService instansiService;
	
	@RequestMapping("/")
	private String home(Model model) {
		return "home";
	}
	
//	View Operation
	@RequestMapping(value = "/pegawai", method=RequestMethod.GET)
	private String viewPegawai(@RequestParam(value="nip") String nip, Model model) {
		Pegawai pegawai = pegawaiService.getByNip(nip);
		if (pegawai.equals(null)) {
			return "redirect:/";
		}
		String gaji = "Rp " + String.format("%.2f", this.calculateGaji(pegawai.getListJabatan()));
		model.addAttribute("gaji",gaji);
		model.addAttribute("pegawai",pegawai);
		return "pegawai/pegawai";
	}
	
//	Add Operation
	@RequestMapping(value="/pegawai/tambah", method=RequestMethod.GET)
	private String tambah(Model model) {

		return "pegawai/addPegawai";
	}
	
//	Update Operation
	@RequestMapping(value="/pegawai/ubah", method=RequestMethod.GET)
	private String ubah(@RequestParam(value="nip") String nip, Model model) {
		List<Jabatan> jabatans = jabatanService.getAll();
		List<Provinsi> provinsis = provinsiService.getAll();
		List<Instansi> instansis = instansiService.getAll();

		model.addAttribute(jabatans);
		model.addAttribute(provinsis);
		model.addAttribute(instansis);
		return "pegawai/updatePegawai";
	}
	
//	Extra
	@RequestMapping(value="/pegawai/termuda-tertua", method=RequestMethod.GET)
	private String lihatPegawaiTer(@RequestParam(value="idInstansi") Long idInstansi, Model model) {
		
		return "pegawai/youngest-oldest";
	}
	
	@RequestMapping(value="/pegawai/cari", method=RequestMethod.GET)
	private String cariPegawai(@RequestParam(value="idProvinsi", required=false, defaultValue="0") Long id_provinsi,
			@RequestParam(value="idInstansi", required=false, defaultValue ="0") Long id_instansi,
			@RequestParam(value="idJabatan", required=false, defaultValue ="0") Long id_jabatan, Model model) {
			
		return "pegawai/searchPegawai";
	}
	
	private double calculateGaji(List<JabatanPegawai> listJabatan) {
		double max = 0;
		for (JabatanPegawai jabatan : listJabatan) {
			double present = jabatan.getJabatan().getGajiPokok() ;
			max = present > max? present : max; 
		}
		return max;
	}
}