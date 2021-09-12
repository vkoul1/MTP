package com.perficient.mtp.profile.symbolprofile;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.mtp.profile.SymbolProfile;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SymbolProfileController {

	private final SymbolProfileService service;

	@GetMapping("/symbol-profile/{ticker}")
	@ResponseBody
	@Timed
	public ResponseEntity<SymbolProfile> getCompanyProfile(@PathVariable String ticker) {
		
		Optional<SymbolProfile> opt = service.getSymbolProfile(ticker);

		return opt.isEmpty()
			? ResponseEntity.notFound().build()
			: new ResponseEntity<>(opt.get(), HttpStatus.OK);
	}

}
