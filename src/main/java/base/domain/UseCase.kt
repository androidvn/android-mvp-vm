package base.domain

interface UseCase<T> {
    fun execute(): T
}
