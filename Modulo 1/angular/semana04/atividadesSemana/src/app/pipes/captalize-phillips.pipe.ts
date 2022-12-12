import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'captalizePhillips',
})
export class CaptalizePhillipsPipe implements PipeTransform {
  transform(value: string): string {
    const words = value.split(' ');

    for (let i = 0; i < words.length; i++) {
      words[i] = words[i][0].toUpperCase() + words[i].substr(1);
    }

    return words.join(' ');
  }
}
