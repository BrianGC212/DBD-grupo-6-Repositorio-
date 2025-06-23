import { TestBed } from '@angular/core/testing';

import { InformeEntregaService } from './informe-entrega-service';

describe('InformeEntregaService', () => {
  let service: InformeEntregaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InformeEntregaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
