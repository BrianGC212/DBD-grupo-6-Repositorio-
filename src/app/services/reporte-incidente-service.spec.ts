import { TestBed } from '@angular/core/testing';

import { ReporteIncidenteService } from './reporte-incidente-service';

describe('ReporteIncidenteService', () => {
  let service: ReporteIncidenteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReporteIncidenteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
