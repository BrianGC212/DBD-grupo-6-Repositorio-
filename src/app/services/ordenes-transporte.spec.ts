import { TestBed } from '@angular/core/testing';

import { OrdenesTransporteService } from './ordenes-transporte-service';

describe('OrdenesTransporte', () => {
  let service: OrdenesTransporteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrdenesTransporteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
