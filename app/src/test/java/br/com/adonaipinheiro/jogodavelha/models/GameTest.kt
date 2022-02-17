package br.com.adonaipinheiro.jogodavelha.models

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GameTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private lateinit var game: Game
    private var player: Player? = null
    private var anotherPlayer: Player? = null

    @Before
    fun setUp() {
        game = Game("Android", "iOS")
        player = game.player1
        anotherPlayer = game.player2
    }

    @Test
    fun `Return True If Has Three Same Horizontal Cell At Row 1`() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertTrue(hasThreeSameHorizontalCells)

    }

    @Test
    fun `Return True If Has Three Same Horizontal Cell At Row 2`() {
        val cell = Cell(player)
        game.cells[1][0] = cell
        game.cells[1][1] = cell
        game.cells[1][2] = cell
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    fun `Return True If Has Three Same Horizontal Cell At Row 3`() {
        val cell = Cell(player)
        game.cells[2][0] = cell
        game.cells[2][1] = cell
        game.cells[2][2] = cell
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    fun `Return False If Does Not Have Three Same Horizontal Cell At Row 1`() {
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = anotherCell
        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()
        assertFalse(hasThreeSameHorizontalCells)
    }

    @Test
    fun `Return True If Has Three Same Vertical Cells At Column 1`() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = cell
        val hasThreeSameVerticalCells =
            game.hasThreeSameVerticalCells()
        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    fun `Return True If Has Three Same Vertical Cells At Column 2`() {
        val cell = Cell(player)
        game.cells[0][1] = cell
        game.cells[1][1] = cell
        game.cells[2][1] = cell
        val hasThreeSameVerticalCells =
            game.hasThreeSameVerticalCells()
        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    fun `Return True If Has Three Same Vertical Cells At Column 3`() {
        val cell = Cell(player)
        game.cells[0][2] = cell
        game.cells[1][2] = cell
        game.cells[2][2] = cell
        val hasThreeSameVerticalCells =
            game.hasThreeSameVerticalCells()
        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    fun `Return True If Does Not Have Three Same Vertical Cells At Column 3`() {
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)
        game.cells[0][2] = cell
        game.cells[1][2] = cell
        game.cells[2][2] = anotherCell
        val hasThreeSameVerticalCells =
            game.hasThreeSameVerticalCells()
        assertFalse(hasThreeSameVerticalCells)
    }

    @Test
    fun returnTrueIfHasThreeSameDiagonalCellsFromLeft() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = cell
        val hasThreeSameDiagonalCells =
            game.hasThreeSameDiagonalCells()
        assertTrue(hasThreeSameDiagonalCells)
    }

    @Test
    fun returnTrueIfHasThreeSameDiagonalCellsFromRight() {
        val cell = Cell(player)
        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = cell
        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertTrue(hasThreeSameDiagonalCells)
    }

    @Test
    fun returnFalseIfDoesNotHaveThreeSameDiagonalCells() {
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)
        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = anotherCell
        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        assertFalse(hasThreeSameDiagonalCells)
    }

    @Test
    fun endGameIfHasThreeSameHorizontalCells() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }

    @Test
    fun endGameIfHasThreeSameVerticalCells() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = cell
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }

    @Test
    fun endGameIfHasThreeSameDiagonalCells() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = cell
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }

    @Test
    fun endGameIfBoardIsFull() {
        val cell1 = Cell(player)
        val cell2 = Cell(player)
        val cell3 = Cell(anotherPlayer)
        val cell4 = Cell(anotherPlayer)
        val cell5 = Cell(player)
        val cell6 = Cell(player)
        val cell7 = Cell(player)
        val cell8 = Cell(anotherPlayer)
        val cell9 = Cell(anotherPlayer)
        game.cells[0][0] = cell1
        game.cells[0][1] = cell2
        game.cells[0][2] = cell3
        game.cells[1][0] = cell4
        game.cells[1][1] = cell5
        game.cells[1][2] = cell6
        game.cells[2][0] = cell7
        game.cells[2][1] = cell8
        game.cells[2][2] = cell9
        val hasGameEnded = game.hasGameEnded()
        assertTrue(hasGameEnded)
    }

}