export interface Page<T> {
  content: T[]; // The array of items on the current page
  totalElements: number; // Total number of items across all pages
  totalPages: number; // Total number of pages
  pageNumber: number; // Current page number
  pageSize: number; // Number of items per page
}
