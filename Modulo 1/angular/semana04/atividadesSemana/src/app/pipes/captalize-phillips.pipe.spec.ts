import { Pipe } from '@angular/core';
import { CaptalizePhillipsPipe } from './captalize-phillips.pipe';

describe('CaptalizePhillipsPipe', () => {
  it('create an instance', () => {
    const pipe = new CaptalizePhillipsPipe();
    expect(pipe).toBeTruthy();
  });

  it('Should capitalize a word', () => {
    const pipe = new CaptalizePhillipsPipe();
    let capitalizedWord = pipe.transform('test');
    expect(capitalizedWord).toBe('Test');
  });
});
