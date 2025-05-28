export enum TipoAtendimento {
  GESTANTE = 'GESTANTE',
  IDOSO = 'IDOSO',
  PCD = 'PCD',
  ENCAMINHADO = 'ENCAMINHADO',
  GERAL = 'GERAL'
}

export interface Cliente {
  id?: number;
  nome: string;
  tipo: TipoAtendimento;
  prioridade?: number;
}
