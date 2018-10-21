package bagas.meyca.apap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bagas.meyca.apap.entity.Instansi;
import bagas.meyca.apap.entity.Jabatan;
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

		model.addAttribute("pegawai",pegawai);
		return "pegawai/pegawai";
	}
	
//	Add Operation
	@RequestMapping(value="/pegawai/tambah", method=RequestMethod.GET)
	private String tambah(@ModelAttribute Pegawai pegawai, Model model, BindingResult bindingResult) {
		List<Jabatan> jabatans = jabatanService.getAll();
		List<Provinsi> provinsis = provinsiService.getAll();
		
		model.addAttribute("title", "Tambah Pegawai");
		model.addAttribute("jabatans", jabatans);
		model.addAttribute("provinsis", provinsis);
		
		return "pegawai/addPegawai";
	}
	
	@RequestMapping(value="/pegawai/tambah",method = RequestMethod.POST, params= {"addRow"})
	private String addRow (@ModelAttribute Pegawai pegawai, Model model, BindingResult bindingResult) {
		if (pegawai.getListJabatan() == null) {
			pegawai.setListJabatan(new ArrayList<Jabatan>());
		}
		System.out.println(pegawai.getListJabatan().size());
		pegawai.getListJabatan().add(new Jabatan());
		
		List<Jabatan> jabatans = jabatanService.getAll();
		List<Provinsi> provinsis = provinsiService.getAll();
		
		model.addAttribute(provinsis);
		model.addAttribute(pegawai);
		model.addAttribute(jabatans);
		model.addAttribute("title", "Tambah Pegawai");
		
		return "TambahPegawai";
	}
	
	@RequestMapping(value = "/pegawai/tambah/instansi",method = RequestMethod.GET)
	private @ResponseBody List<Instansi> cekInstansi(@RequestParam(value="provinsiId") long id) {
		Provinsi provinsi = provinsiService.get(id);
		
		return provinsi.getListInstansi();
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
	
	
}