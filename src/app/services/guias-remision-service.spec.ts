import { TestBed } from '@angular/core/testing';

import { GuiasRemisionService } from './guias-remision-service';

describe('GuiasRemisionService', () => {
  let service: GuiasRemisionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GuiasRemisionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
